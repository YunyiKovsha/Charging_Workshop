package com.su.sharkmanfunc

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.preference.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SettingsFragmentCompat : PreferenceFragmentCompat(), Preference.OnPreferenceClickListener {

    companion object {
        var isEnableAudio = false
        var isClickClose = true
        var isOpenOnClock = false
        var isKeepShow = false
        var isNotOpenOnFull = true
        var isForegroundService = true
        private const val SOUNDS_PATH = "sounds"
    }

    private var foregroundService: SwitchPreference? = null

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.pre_settings, rootKey)
        //以前台服务方式启动
        foregroundService = findPreference(getString(R.string.charge_foreground_service))
        foregroundService?.apply {
            isEnabled = !SharkManChargeService.isOpen
            isForegroundService = isChecked
            onPreferenceClickListener = Preference.OnPreferenceClickListener {
                if (it is SwitchPreference)
                    isForegroundService = isChecked
                true
            }
        }
        //充电守护服务
        findPreference<SwitchPreference>(getString(R.string.charge_service))?.apply {
            isChecked = SharkManChargeService.isOpen
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference) {
                        val intent = Intent(requireContext(), SharkManChargeService::class.java)
                        if (it.isChecked) {
                            if (ChargeAudioManager.INS.checkIsEmptyAudio())
                                Toast.makeText(
                                    requireContext(),
                                    "服务已启动，但尚未设置音频(拉到下方设置)，因此无论什么状态都不会发声。",
                                    Toast.LENGTH_LONG
                                ).show()
                            requireActivity().startService(intent)
                        } else
                            requireActivity().stopService(intent)
                        //锁定前台服务设置
                        foregroundService?.isEnabled = !it.isChecked
                    }
                    true
                }
        }
        //是否播放音频
        findPreference<SwitchPreference>(getString(R.string.charge_is_audio))?.apply {
            isEnableAudio = isChecked
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference)
                        isEnableAudio = it.isChecked
                    true
                }
        }

        findPreference<SwitchPreference>(getString(R.string.charge_click_close))?.apply {
            isClickClose = isChecked
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference)
                        isClickClose = it.isChecked
                    true
                }
        }
        //亮屏守护
        findPreference<SwitchPreference>(getString(R.string.charge_screen_on_open))?.apply {
            isOpenOnClock = isChecked
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference)
                        isOpenOnClock = it.isChecked
                    true
                }
        }
        //守护常亮
        findPreference<SwitchPreference>(getString(R.string.charge_keep_show))?.apply {
            isKeepShow = isChecked
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference)
                        isKeepShow = it.isChecked
                    true
                }
        }
        //隐藏最近任务
        findPreference<SwitchPreference>(getString(R.string.is_clear_recent))?.apply {
            setTaskRecent(requireContext(), isChecked)
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference)
                        setTaskRecent(requireContext(), isChecked)
                    true
                }
        }
        //勿扰模式
        findPreference<SwitchPreference>(getString(R.string.is_not_open_on_full))?.apply {
            isNotOpenOnFull = isChecked
            onPreferenceClickListener =
                Preference.OnPreferenceClickListener {
                    if (it is SwitchPreference) {
                        isNotOpenOnFull = it.isChecked
                        if (!isNotOpenOnFull)
                            PhoneUtils.removeCheckFullView(requireContext())
                        else if (SharkManChargeService.isOpen)
                            PhoneUtils.checkIsOnFullScreen(requireContext())
                    }
                    true
                }
        }

        initSounds()
    }

    private inline fun setTaskRecent(context: Context, isClear: Boolean) {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        am.appTasks?.get(0)?.setExcludeFromRecents(isClear)
    }

    private fun initSounds() {
        findPreference<PreferenceCategory>(getString(R.string.charge_sounds))?.apply {
            MainScope().launch {
                withContext(Dispatchers.IO) {
                    ChargeAudioManager.getFlags(context)
                }.also { flagData ->
                    withContext(Dispatchers.IO) {
                        val am = context.assets
                        am.list(SOUNDS_PATH)
                    }.also { list ->
                        val flags = SoundPreference.AudioFlag.values()
                        try {
                            val suffixRegex = Regex("\\..+")
                            list?.forEach {
                                //创建音频Preference
                                Log.d("文件", it)
                                val pre =
                                    SoundPreference(requireContext(), "${SOUNDS_PATH}/$it").apply {
                                        title = it.replace(suffixRegex, "")
                                        isIconSpaceReserved = false
                                    }
                                pre.onPreferenceClickListener = this@SettingsFragmentCompat
                                //读取音频Flag设置
                                flagData?.get(pre.title)?.forEach { flag ->
                                    pre.changeFlag(flags[flag])
                                } ?: ChargeAudioManager.INS.launchSyncAudio(pre)

                                addPreference(pre)
                            }
                        } catch (e: Exception) {
                        }
                    }
                }
            }
        }
    }

    private fun traversAssets(context: Context, path: String) {
        val am = context.assets

    }

    override fun onPause() {
        super.onPause()
        ChargeAudioManager.saveFlags(requireContext())
    }

    private var lastClickPreference: SoundPreference? = null
    private val chooseDialog by lazy {
        val items =
            arrayOf(
                "播放",
                *SoundPreference.AudioFlag.values().map { "设置为\"${it.flag}\"音频" }.toTypedArray()
            )
        val listDialog: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        listDialog.setTitle("操作")
        listDialog.setItems(
            items
        ) { _, which ->
            lastClickPreference?.apply {
                if (which == 0)
                    playAudio()
                else {
                    changeFlag(SoundPreference.AudioFlag.values()[which - 1])
                    syncFlags()
                }
            }
        }
    }

    override fun onPreferenceClick(preference: Preference?): Boolean {
        lastClickPreference = preference as SoundPreference?
        chooseDialog.show()
        return true
    }

}