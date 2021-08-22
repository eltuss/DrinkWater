package com.example.drinkwater.sync

import android.content.Context
import com.example.drinkwater.utils.PreferencesUtils

class DrinkWaterReminderTask {
    //001 - Foi criada uma String constante estatica chamada ACTION_INCREMENT_WATER_COUNT para representar a ação de incrementar o contador
    companion object{
     const val ACTION_INCREMENT_WATER_COUNT = "action-increment-water-count"

        /*002 -
       - Foi criado uma função privada chamada incrementWaterCount para incrementar o contador de copo de águas
       - Foi incluido um Context como parametro da função
       - Chamamos o metodo incrementWaterCount da classe PreferencesUtils
     */
        private fun  incrementWaterCount(context: Context){
            PreferencesUtils.incrementWaterCount(context)
        }

        /*003 -
      - Foi criado um método publico e estatico para executar a tarefa
      - Coloquei um Context como parametro e uma string chamada action
      - Quando a action for igual a constante ACTION_INCREMENT_WATER_COUNT chame o método incrementWaterCount desta classe
    */
        fun executTask(context: Context, action: String?){
            if (ACTION_INCREMENT_WATER_COUNT == action){
                incrementWaterCount(context)
            }
        }
    }
}