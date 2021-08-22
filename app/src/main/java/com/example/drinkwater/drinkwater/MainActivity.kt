package com.example.drinkwater.drinkwater

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.drinkwater.R
import com.example.drinkwater.sync.DrinkWaterReminderIntentService
import com.example.drinkwater.sync.DrinkWaterReminderTask
import com.example.drinkwater.utils.PreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //008 - Realize a chamada da função updateWaterCount
        updateWaterCount()


        imageView_cup_icon.setOnClickListener {
            //009 - Chamei a função incrementWaterHandler
            incrementWaterHandler()
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

/*007 - criei uma função updateWaterCount
    - Atualize o textview_quantity com o valor da PreferencesUtils.getWaterCount
 */
    fun updateWaterCount(){
    val count = PreferencesUtils.getWaterCount(this)
        textview_quantity.text = "${count}"
    }

/*008 - criei uma função chamada incrementWaterHandler
    - Criei uma intent explicita para acionar o DrinkWaterReminderIntentService
    - Defini a action da Intent com a constant ACTION_INCREMENT_WATER_COUNT
    - Chamei startService e passe a intent como parametro
 */
    fun incrementWaterHandler(){
        val intent = Intent(this, DrinkWaterReminderIntentService::class.java)
    intent.action = DrinkWaterReminderTask.ACTION_INCREMENT_WATER_COUNT
    startService(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        //010 - Chamei o método updateWaterCount se o parametro key for igual a constante PrefencesUtils.KEY_WATER_COUNT
        if (PreferencesUtils.KEY_WATER_COUNT == key){
            updateWaterCount()
        }
    }
}
