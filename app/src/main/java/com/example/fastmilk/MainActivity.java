package com.example.fastmilk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fastmilk.Fragment.Chitietdonhang;
import com.example.fastmilk.Fragment.Danhsachdonhang;
import com.example.fastmilk.Fragment.MapsFragment;
import com.example.fastmilk.Fragment.NhanVienFragment;
import com.example.fastmilk.Fragment.ThongKeDonHang;
import com.example.fastmilk.models.DonHang;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private BottomNavigationView navigationView;
    private FragmentManager fragmentManager;
    public static ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCanceledOnTouchOutside(false);

        loadFragment(new MapsFragment());


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        fragment = new MapsFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.menu_donhang:
                        fragment = new Danhsachdonhang();
                        loadFragment(fragment);
                        return true;
                    case R.id.menu_lichsuGH:
                        fragment = new ThongKeDonHang();
                        loadFragment(fragment);
                        return true;
                    case R.id.menu_taikhoan:
                        fragment = new NhanVienFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_xac_nhan,null);
        TextView xacnhan=view.findViewById(R.id.tvXacNhan);
        xacnhan.setText("B???n c?? mu???n ????ng xu???t t??i kho???n n??y kh??ng?");
        Button yes=view.findViewById(R.id.yes);
        Button no=view.findViewById(R.id.no);
        builder.setView(view);
        builder.setCancelable(false);
        AlertDialog dialog=builder.create();
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
                dialog.dismiss();
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        super.onBackPressed();
    }

    private void delete() {
        SharedPreferences sharedPreferences = getSharedPreferences("NV_active.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("idNV",-1);
        editor.putString("tenNV", "");
        editor.putString("taiKhoan", "");
        editor.putString("matKhau", "");
        editor.putString("SDT", "");
        editor.putString("chucVu", "");
        editor.putBoolean("ghiNho", false);
        editor.commit();
    }
}

