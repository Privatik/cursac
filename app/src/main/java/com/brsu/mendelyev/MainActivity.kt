package com.brsu.mendelyev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.frogggias.smarttable.provider.SmartTableProvider
import com.frogggias.smarttable.provider.SmartTableColumn
import com.frogggias.smarttable.filter.SimpleColumnCursorFilterProvider
import com.frogggias.smarttable.filter.ColumnFilterCursorProvider
import com.frogggias.smarttable.activity.SmartTableActivity


class MainActivity : SmartTableActivity() {

    override fun getSmartTableProvider(): SmartTableProvider {
        val factory = SmartTableColumn.Factory()
        factory.setDefaultSearchable(true)
        factory.setDefaultSortable(true)

        // Filtrable column
        val name1 = factory.create(ContactsContract.Contacts.DISPLAY_NAME)
        val name1FilterProvider = SimpleColumnCursorFilterProvider(
            ContactsContract.Contacts.CONTENT_URI,
            ContactsContract.Contacts.DISPLAY_NAME
        )
        name1.filterProvider = name1FilterProvider

        val name2 = factory.create(ContactsContract.Contacts.DISPLAY_NAME)
        name2.isSortable = false

        return SmartTableProvider.Builder(ContactsContract.Contacts.CONTENT_URI)
            .addColumn(name1)
            .addColumn(name2)
            .build()
    }
}
