package com.jqk.mydemo.jetpack.room

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.jqk.mydemo.R
import com.jqk.mydemo.databinding.ActivityRoomBinding
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by jiqingke
 * on 2019/2/19
 */

// Room配合Rx使用时，如果使用Observable和Flowable对象，当数据库改变时观察者会收到通知，使用Single则不会
class RoomActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomBinding
    val db: AppDatabase by lazy {
        Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room)
        binding.view = this
    }

    fun insert(view: View) {
        val user = User(1, "", "", 10, "")
        db.userDao().insertUsers(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Long> {
                    override fun onSuccess(t: Long) {
                        Log.d("jiqingke", "insert " + t)
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        Log.d("jiqingke", "onError = " + e.toString())
                    }
                })
    }

    fun queryAll(view: View) {
        db.userDao().loadAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Array<User>> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: Array<User>) {
                        for (user: User in t) {
                            Log.d("jiqingke", "queryAll = " + user)
                        }
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    fun query(view: View) {

    }
}