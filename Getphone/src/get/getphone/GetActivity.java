package get.getphone;

 import android.app.Activity;
    import android.content.Intent;
    import android.database.Cursor;
    import android.net.Uri;
    import android.os.Bundle;
    import android.provider.Contacts.People;
    import android.provider.ContactsContract.Contacts;
    import android.provider.ContactsContract.PhoneLookup;
    import android.view.Menu;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.TextView;

    public class GetActivity extends Activity {
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        tv = (TextView) findViewById(R.id.tv1);
        b = (Button) findViewById(R.id.but);
        b.setOnClickListener(new OnClickListener() {
        	
        
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(Intent.ACTION_PICK,People.CONTENT_URI);
            startActivityForResult(intent, 100);
        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.get, menu);
    return true;
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Uri contact = data.getData();
    Cursor c = managedQuery(contact, null, null, null, null);
    c.moveToFirst();
    tv.setText(c.getString(c.getColumnIndex(People.NUMBER)));
}
    }
