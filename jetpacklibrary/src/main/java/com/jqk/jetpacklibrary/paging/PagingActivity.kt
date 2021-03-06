package com.jqk.jetpacklibrary.paging

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jqk.jetpacklibrary.R
import com.jqk.jetpacklibrary.databinding.ActivityPagingBinding
import com.jqk.jetpacklibrary.paging.byitem.ByItemActivity
import com.jqk.jetpacklibrary.paging.bypage.ByPageActivity

/**
 * Created by jiqingke
 * on 2019/2/14
 */
class PagingActivity : AppCompatActivity() {
    lateinit var binding: ActivityPagingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_paging)
        binding.view = this
    }

    fun byPage(view: View) {
        var intent = Intent()
        intent.setClass(this, ByPageActivity().javaClass)
        startActivity(intent)
    }

    fun byItem(view: View) {
        var intent = Intent()
        intent.setClass(this, ByItemActivity().javaClass)
        startActivity(intent)
    }
}