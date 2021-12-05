package com.example.fastmilk.retrofit;



import com.example.fastmilk.models.DiemGiao;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.DonHangChiTiet;
import com.example.fastmilk.models.Message;
import com.example.fastmilk.models.NhanVien;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IRetrofitService {

    /*

    @POST("views/user_login.php")
    Call<ResponeModel> login(@Body Account account);

    @POST("views/product_get_all.php")
    Call<List<Product>> getAllProduct();


    @Multipart
    @POST("/")
    Call<Response2PikModel> upload2pik(@Part MultipartBody.Part image);

    @POST("views/product_category_get_all.php")
    Call<List<ProductCategory>> getAllCategories();

    @POST("views/product_insert.php")
    Call<ResponseModel> insert(@Body Product product);

    @POST("views/product_get_by_id.php")
    Call<Product> getProductById(@Body Product product);

    @POST("views/product_update.php")
    Call<ResponseModel> update(@Body Product product);

     */


    @POST("views/nhan_vien_login.php")
    Call<NhanVien> login(@Body NhanVien nv);

    @POST("views/don_hang_get_all.php")
    Call<List<DonHang>> getAll(@Body NhanVien nv);

    @POST("views/don_hang_get_by_id.php")
    Call<List<DonHangChiTiet>> getDonByID(@Body DonHang dh);

    @POST("views/don_hang_update_TC.php")
    Call<Message> updateTC(@Body DonHang dh);

    @POST("views/don_hang_update_TB.php")
    Call<Message> updateTB(@Body DonHang dh);

    @POST("views/diem_giao_get_by_id.php")
    Call<DiemGiao> getDiemGiao(@Body DiemGiao diemGiao);

    @POST("views/diem_giao_report.php")
    Call<Message> postDiemGiao(@Body DiemGiao diemGiao);

    @FormUrlEncoded
    @POST("update.php")
    Call<Message> update(@Field("idNV") int idNV,
                         @Field("tenNV") String tenNV,
                         @Field("matKhau") String matKhau,
                         @Field("SDT") String SDT,
                         @Field("chucVu") String chucVu
    );
}
