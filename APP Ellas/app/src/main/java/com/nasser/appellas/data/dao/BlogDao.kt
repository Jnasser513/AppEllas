package com.nasser.appellas.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nasser.appellas.data.entity.Blog

@Dao
interface BlogDao {

    //Insertar o actualizar blog
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateBlog(blog: Blog)

    //Obtener todos los blogs
    @Query("SELECT * FROM blog_table")
    fun findAllBlogs(): LiveData<List<Blog>>

    //Obtener un blog
    @Query("SELECT * FROM blog_table WHERE id = :query")
    suspend fun searchBlog(query: Int): Blog

    //Eliminar blog
    @Delete
    suspend fun deleteBlog(blog: Blog)
}