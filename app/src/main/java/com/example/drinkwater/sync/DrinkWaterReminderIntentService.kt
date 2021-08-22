package com.example.drinkwater.sync

import android.app.IntentService
import android.content.Intent

//004 - Extendi a classe IntentService e no construtor passe o parâmetro com o mesmo nome desta classe
class DrinkWaterReminderIntentService(): IntentService("DrinkWaterReminderIntentService"){

    /*005 - Sobrescrevi o metodo onHandleIntent
        - Pegue a ação da intent que startou este service
        - Chame o método DrinkWaterReminderTask.executeTask e passe a action no parâmetro
     */
    override fun onHandleIntent(intent: Intent?) {
        val action = intent?.action
        DrinkWaterReminderTask.executTask(this, action)
    }


}