package me.tiptap.tiptap.diaries

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.Observable
import me.tiptap.tiptap.data.Diary
import me.tiptap.tiptap.databinding.ItemDiaryBinding

class DiariesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: ItemDiaryBinding? = DataBindingUtil.bind(itemView)


    fun getClickObservable(item: Diary): Observable<Diary> =
            Observable.create { emitter ->
                itemView.setOnClickListener {
                    emitter.onNext(item)
                }
            }

    fun getLongClickObservable(): Observable<View> =
            Observable.create { emitter ->
                itemView.setOnLongClickListener {
                    emitter.onNext(it)
                    true
                }
            }

    fun getCheckObservable(item: Diary): Observable<Diary> =
            Observable.create { emitter ->
                binding?.checkDiary?.setOnCheckedChangeListener { _, state ->
                    item.isSelected = state
                    emitter.onNext(item)
                }
            }
}