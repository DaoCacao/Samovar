package core.legion.samovar.base

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseVH<in I>(parent: ViewGroup, @LayoutRes layout: Int) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false)) {

    abstract fun bind(item: I)
}