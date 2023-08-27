package ir.umut.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.umut.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferences = getSharedPreferences( "data", Context.MODE_PRIVATE )
        //put data into sharedPreferences =>
        binding.btnSummit.setOnClickListener {
            //Method 1 =>
            val name = binding.edtName.text.toString()
            sharedPreferences.edit().putString("name",name).apply()
            val email = binding.edtEmail.text.toString()
            sharedPreferences.edit().putString("Email",email).apply()

            if (binding.radioMale.isChecked){
                sharedPreferences.edit().putBoolean("isMale",true).apply()
            }else{
                sharedPreferences.edit().putBoolean("isMale",false).apply()
            }

            //Method 2 =>
            /*
            val editor = sharedPreferences.edit()
            editor.putString("name",name)
            editor.putString("email",email)
            if (binding.radioMale.isChecked){
                editor.putBoolean("isMale",true)
            }else{
                editor.putBoolean("isMale",false)-
            }
            editor.apply()
             */

        }

        //get data from sharedPreferences =>
        val name = sharedPreferences.getString("name","")
        val email = sharedPreferences.getString("Email","")
        val isMale = sharedPreferences.getBoolean("isMale",true)

        binding.edtName.setText(name)
        binding.edtEmail.setText(email)
        if(isMale){
            //male =>
            binding.radioMale.isChecked = true
        }else{
            //female =>
            binding.radioFemale.isChecked = false
        }





    }
}