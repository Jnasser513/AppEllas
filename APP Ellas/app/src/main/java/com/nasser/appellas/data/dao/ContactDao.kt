package com.nasser.appellas.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nasser.appellas.data.entity.TrustContacts

@Dao
interface ContactDao {

    //Insertar o actualizar contacto
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateContact(contact: TrustContacts)

    //Obtener todos los contactos
    @Query("SELECT * FROM contacts_table")
    fun findAllContacts(): LiveData<List<TrustContacts>>

    //Obtener un contacto
    @Query("SELECT * FROM contacts_table WHERE id = :query")
    suspend fun searchContact(query: Int): TrustContacts

    //Eliminar contacto
    @Delete
    suspend fun deleteContact(contact: TrustContacts)
}