package id.sch.smktelkom_mlg.tugas01.xirpl6003.pengiriman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etpengirim, ettujuan;
    TextView tvhasil1, tvhasil2, tvhasil3;
    Button OK;
    RadioButton rbPn, rbPo;
    Spinner spbarang;
    CheckBox id, kp, kb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbPn = (RadioButton) findViewById(R.id.perusahaan);
        rbPo = (RadioButton) findViewById(R.id.perorangan);
        kp = (CheckBox) findViewById(R.id.kp);
        id = (CheckBox) findViewById(R.id.id);
        kb = (CheckBox) findViewById(R.id.kb);
        tvhasil1 = (TextView) findViewById(R.id.hasil1);
        OK = (Button) findViewById(R.id.OK);
        tvhasil2 = (TextView) findViewById(R.id.hasil2);
        tvhasil3 = (TextView) findViewById(R.id.hasil3);
        spbarang = (Spinner) findViewById(R.id.barang);
        etpengirim = (EditText) findViewById(R.id.editText);
        ettujuan = (EditText) findViewById(R.id.editText2);

        findViewById(R.id.OK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
                doProcess();
            }
        });

    }

    private void doClick() {
        String hasil2 = null;
        if (rbPn.isChecked()) {
            hasil2 = rbPn.getText().toString();
        } else if (rbPo.isChecked()) {
            hasil2 = rbPo.getText().toString();
        }
        if (hasil2 == null) {
            tvhasil2.setText("Belum Teridentifikasi");
        } else {
            tvhasil2.setText("Kriteria Anda : " + hasil2);
        }
        tvhasil3.setText("Kriteria Barang : " + spbarang.getSelectedItem().toString());

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etpengirim.getText().toString();
            String tujuan = ettujuan.getText().toString();
            tvhasil1.setText("Identitas Anda : " + nama + "\n" + "tujuan : " + tujuan);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etpengirim.getText().toString();

        if (nama.isEmpty()) {
            etpengirim.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 4) {
            etpengirim.setError("Nama Minimal 4 Karakter");
            valid = false;
        } else {
            etpengirim.setError(null);
        }
        return valid;
    }
}
