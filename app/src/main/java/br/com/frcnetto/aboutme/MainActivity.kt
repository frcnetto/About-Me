package br.com.frcnetto.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import br.com.frcnetto.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName = MyName("Netto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(v: View){

        binding.apply {
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            changeVisibility(nicknameEdit, View.GONE)
            changeVisibility(v, View.GONE)
            changeVisibility(nicknameText, View.VISIBLE)
        }

        hideKeyboard(v)
    }

    private fun changeVisibility(view: View, visibility: Int) {
        view.visibility = visibility
    }

    private fun hideKeyboard(view: View){
        val inputMethodManager =  getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
