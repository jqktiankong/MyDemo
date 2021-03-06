package com.jqk.mydemo.rx

import com.jqk.commonlibrary.util.L
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class RxKotlin {

    fun main() {

        when ("") {
            "a" -> {

            }
        }

        val items = listOf(1, 2, 3, 4, 5)

// Lambdas 表达式是花括号括起来的代码块。
//        items.fold(0, {
//            // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
//            acc: Int, i: Int ->
//            print("acc = $acc, i = $i, ")
//            val result = acc + i
//            println("result = $result")
//            // lambda 表达式中的最后一个表达式是返回值：
//            result
//        })

// lambda 表达式的参数类型是可选的，如果能够推断出来的话：
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

// 函数引用也可以用于高阶函数调用：
        val product = items.fold(1, Int::times)

    }

    fun map() {
        Observable.create<Int> {
            it.onNext(1)
            it.onComplete()
        }.subscribe(object : Consumer<Int> {
            override fun accept(t: Int?) {

            }
        }, object : Consumer<Throwable> {
            override fun accept(t: Throwable?) {

            }
        }, object : Action {
            override fun run() {
                com.jqk.commonlibrary.util.L.d("onComplete")
            }
        }, object : Consumer<Disposable> {
            override fun accept(t: Disposable?) {

            }
        })

        Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(1)
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(object : Observer<Int> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: Int) {

                    }

                    override fun onError(e: Throwable) {

                    }
                })

        Observable.create<Int> {
            it.onNext(1)
        }.subscribe({}, { error -> com.jqk.commonlibrary.util.L.d("error = " + error.toString()) }, {}, { t: Disposable? -> })
    }
}