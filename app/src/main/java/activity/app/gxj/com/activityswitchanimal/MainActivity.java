package activity.app.gxj.com.activityswitchanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.listView1);
        String[] ls = getResources().getStringArray(R.array.anim_type);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < ls.length; i++) {
            list.add(ls[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                switch (position) {
                    case 0:
                        //淡入淡出效果
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        break;
                    case 1:
                        //放大淡出效果
                        overridePendingTransition(R.anim.my_scale_action,
                                R.anim.my_alpha_action);
                        break;
                    case 2:
                        //转动淡出效果1
                        overridePendingTransition(R.anim.scale_rotate,
                                R.anim.my_alpha_action);
                        break;
                    case 3:
                        //转动淡出效果2
                        overridePendingTransition(R.anim.scale_translate_rotate,
                                R.anim.my_alpha_action);
                        break;
                    case 4:
                        //左上角展开淡出效果
                        overridePendingTransition(R.anim.scale_translate,
                                R.anim.my_alpha_action);
                        break;
                    case 5:
                        //压缩变小淡出效果
                        overridePendingTransition(R.anim.hyperspace_in,
                                R.anim.hyperspace_out);
                        break;
                    case 6:
                        //右往左推出效果
                        overridePendingTransition(R.anim.push_left_in,
                                R.anim.push_left_out);
                        break;
                    case 7:
                        //下往上推出效果
                        overridePendingTransition(R.anim.push_up_in,
                                R.anim.push_up_out);
                        break;
                    case 8:
                        //左右交错效果
                        overridePendingTransition(R.anim.slide_left,
                                R.anim.slide_right);
                        break;
                    case 9:
                        //放大淡出效果
                        overridePendingTransition(R.anim.wave_scale,
                                R.anim.my_alpha_action);
                        break;
                    case 10:
                        //缩小效果
                        overridePendingTransition(R.anim.zoom_enter,
                                R.anim.zoom_exit);
                        break;
                    case 11:
                        //上下交错效果
                        overridePendingTransition(R.anim.slide_up_in,
                                R.anim.slide_down_out);
                        break;

                    default:
                        break;
                }

            }
        });
    }
}
