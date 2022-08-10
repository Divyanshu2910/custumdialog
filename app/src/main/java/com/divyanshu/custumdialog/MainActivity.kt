package com.divyanshu.custumdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import com.divyanshu.custumdialog.databinding.ActivityMainBinding
import com.divyanshu.custumdialog.databinding.ActivityMainBinding.inflate
import com.divyanshu.custumdialog.databinding.CustumdialogBinding
import com.divyanshu.custumdialog.databinding.CustumdialogBinding.inflate

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
            var dialogBinding = CustumdialogBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.etName.setText(binding.etName.text.toString())
            dialogBinding.etAddress.setText(binding.etAddress.text.toString())
            if (binding.etGender.text.toString().equals("Male")) {
                dialogBinding.rbMale.isChecked = true
            } else if (binding.etGender.text.toString().equals("Female")) {
                dialogBinding.rbFemale.isChecked = true
            } else if (binding.etGender.text.toString().equals("others")) {
                dialogBinding.rbTransgender.isChecked = true
            } else {
            }

            dialogBinding.btnUpdatein.setOnClickListener{

                if(dialogBinding.etName.text.toString().isNullOrEmpty()){
                    Toast.makeText(this,getString(R.string.enter_name),Toast.LENGTH_SHORT).show()
                }
                else if(dialogBinding.etAddress.text.toString().isNullOrEmpty()){
                    Toast.makeText(this,getString(R.string.enter_address),Toast.LENGTH_SHORT).show()
                }
                else{
                    binding.etName.setText(dialogBinding.etName.text.toString())
                    binding.etAddress.setText(dialogBinding.etAddress.text.toString())
                    if(dialogBinding.rbMale.isChecked){
                        binding.etGender.setText("Male")
                    }
                    else if(dialogBinding.rbFemale.isChecked){
                        binding.etGender.setText("Female")
                    }
                    else {
                        binding.etGender.setText("others")
                    }
                    dialog.dismiss()
                }


            }
            dialog.show()
        }
    }

}