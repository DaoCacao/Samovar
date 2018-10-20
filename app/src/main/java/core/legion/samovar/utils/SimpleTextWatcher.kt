package core.legion.samovar.utils

import android.text.Editable
import android.text.TextWatcher

class SimpleTextWatcher(private val after: ((String) -> Unit)) : TextWatcher {
    override fun afterTextChanged(s: Editable?) = after.invoke(s.toString())
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}