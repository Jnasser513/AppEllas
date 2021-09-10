package com.nasser.appellas.repository

import com.nasser.appellas.data.dao.BlogDao
import com.nasser.appellas.data.dao.ContactDao
import com.nasser.appellas.data.dao.UserDao
import com.nasser.appellas.data.entity.Blog
import com.nasser.appellas.data.entity.TrustContacts
import com.nasser.appellas.data.entity.User
import com.nasser.appellas.network.AppApi

class AppRepository(private val userDao: UserDao,
                    private val blogDao: BlogDao,
                    private val contactDao: ContactDao,
                    private val api: AppApi)
{

    val API = AppApi.service

    //Funciones de usuario
    suspend fun insertOrUpdateUser(user: User) = userDao.insertOrUpdateUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    suspend fun searchUser(user: String) = userDao.searchUser(user)
    suspend fun searchUsers(key: String) = API.searchUser(key)
    fun findAllUsers() = userDao.findAllUsers()


    //Funciones de blog
    suspend fun insertOrUpdateBlog(blog: Blog) = blogDao.insertOrUpdateBlog(blog)
    suspend fun deleteBlog(blog: Blog) = blogDao.deleteBlog(blog)
    suspend fun searchBlog(query: Int) = blogDao.searchBlog(query)
    fun findAllBlogs() = blogDao.findAllBlogs()

    //Funciones de contactos
    suspend fun insertOrUpdateContact(contact: TrustContacts) = contactDao.insertOrUpdateContact(contact)
    suspend fun searchContact(query: Int) = contactDao.searchContact(query)
    fun findAllContacts() = contactDao.findAllContacts()
    suspend fun deleteContact(contact: TrustContacts) = contactDao.deleteContact(contact)
}