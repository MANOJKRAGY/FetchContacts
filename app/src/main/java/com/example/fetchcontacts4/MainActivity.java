package com.example.fetchcontacts4;

import android.content.ContentResolver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button loadContacts;
    public TextView listContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContacts = (TextView) findViewById(R.id.listContacts);
        loadContacts = (Button) findViewById(R.id.loadContacts);
        final ContentResolver contentResolver = getContentResolver();
        loadContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MultiTask mt = new MultiTask();
                MultiTask.loadContact(listContacts,contentResolver);
            }
        });
    }
}
//    public class MultiTask extends AsyncTask<String,String,String> {
//
//        public  void loadContact(TextView listContacts,ContentResolver contentResolver) {
//        StringBuilder builder = new StringBuilder();
//       // ContentResolver contentResolver = getContentResolver();
//        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
//        if (cursor.getCount() > 0) {
//            while (cursor.moveToNext()) {
//                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
//
//                if (hasPhoneNumber > 0) {
//                    Cursor cursor1 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                            null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
//                            new String[]{id}, null);
//                    while (cursor1.moveToNext()) {
//                        String phoneNumber = cursor1.getString(cursor1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        builder.append("Contact :").append(name).append(",Phone Number :").append(phoneNumber).append("\n\n");
//                    }
//                    cursor1.close();
//
//                }
//            }
//        }
//        cursor.close();
//        listContacts.setText(builder.toString());
//    }
//    }




