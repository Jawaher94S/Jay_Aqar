package qa.edu.qu.cmps312.jayaqar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

/**
 * Created by almesaifri on 12/5/16.
 */

public class offerActivity extends AppCompatActivity {

    // TODO: by creating adapter to show the offer, either all, rents, or sales.
    // TODO: from database will retrieve list of property and send it to adapter.

    ListView propertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers);


        offersAdapter myAdapter = new offersAdapter();
        propertyList = (ListView)findViewById(R.id.list);
        propertyList.setAdapter(myAdapter);

        TabHost tabHost = (TabHost)findViewById(R.id.property);
        tabHost.setup();
        TabHost.TabSpec all_tabSpec = tabHost.newTabSpec("All Offers"); // all offer tab
        all_tabSpec.setIndicator("All Offers");
        all_tabSpec.setContent(R.id.all);

        tabHost.addTab(all_tabSpec); // add the tab to the host

        TabHost.TabSpec rent_tapSpec = tabHost.newTabSpec("Rent");
        rent_tapSpec.setIndicator("Rent");
        rent_tapSpec.setContent(R.id.rents);

        tabHost.addTab(rent_tapSpec);

        TabHost.TabSpec sale_tapSpec = tabHost.newTabSpec("Sale");
        sale_tapSpec.setIndicator("Sale");
        sale_tapSpec.setContent(R.id.sales);

        tabHost.addTab(sale_tapSpec);
    }
}
