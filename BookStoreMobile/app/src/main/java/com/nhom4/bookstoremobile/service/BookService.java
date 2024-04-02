package com.nhom4.bookstoremobile.service;


import androidx.annotation.Nullable;

import com.nhom4.bookstoremobile.entities.Book;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface BookService {
    @GET("books")
    Call<List<Book>> getBookFromRestAPI();

    @GET("topselling")
    Call<List<Book>> getBookTopSellingFromRestAPI();

    @GET("books/{id}")
    Call<Book> getBookDetailsFromRestAPI(@Path("id") String bookId);

    @Multipart
    @POST("books")
    Call<Book> addBook(
            @Part MultipartBody.Part image,
            @Part("book") Book book
    );

    @Multipart
    @PUT("books/{id}")
    Call<String> editBook(
            @Path("id") String bookId,
            @Part @Nullable MultipartBody.Part image,
            @Part("book") Book book
    );

    @DELETE("books/{id}")
    Call<ResponseBody> deleteBook(@Path("id") String id);
}
