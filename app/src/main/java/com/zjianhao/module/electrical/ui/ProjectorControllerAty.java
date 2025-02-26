package com.zjianhao.module.electrical.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zjianhao.universalcontroller.R;

import at.markushi.ui.CircleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 张建浩（Clarence) on 2017-4-23 22:52.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 * contact: zhangjianhao1111@gmail.com
 */

public class ProjectorControllerAty extends ControllerAty {
    @BindView(R.id.buton_ok)
    Button butonOk;
    @BindView(R.id.dvd_up)
    CircleButton projectorUp;
    @BindView(R.id.projector_left)
    CircleButton projectorLeft;
    @BindView(R.id.projector_down)
    CircleButton projectorDown;
    @BindView(R.id.projector_right)
    CircleButton projectorRight;
    @BindView(R.id.projector_power)
    LinearLayout projectorPower;
    @BindView(R.id.projector_menu)
    LinearLayout projectorMenu;
    @BindView(R.id.projector_mute)
    LinearLayout projectorMute;
    @BindView(R.id.sound_sub)
    LinearLayout soundSub;
    @BindView(R.id.sound_add)
    LinearLayout soundAdd;

    private boolean isOpen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ele_controller_projector_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.buton_ok, R.id.dvd_up, R.id.projector_left, R.id.projector_down, R.id.projector_right, R.id.projector_power, R.id.projector_menu, R.id.projector_mute, R.id.sound_sub, R.id.sound_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buton_ok:
                send(view, "ok");
                break;
            case R.id.dvd_up:
                send(view, "up");
                break;
            case R.id.projector_left:
                send(view, "left");
                break;
            case R.id.projector_down:
                send(view, "down");
                break;
            case R.id.projector_right:
                send(view, "right");
                break;
            case R.id.projector_power:
                isOpen = !isOpen;//改变状态
                System.out.println("state:" + isOpen);
                if (cmdKeys.containsKey("poweroff")) {
                    if (isOpen)
                        send(view, "power");
                    else
                        send(view, "poweroff");
                } else
                    send(view, "power");
                break;
            case R.id.projector_menu:
                send(view, "menu");
                break;
            case R.id.projector_mute:
                send(view, "mute");
                break;
            case R.id.sound_sub:
                send(view, "volsub");
                break;
            case R.id.sound_add:
                send(view, "voladd");
                break;
        }
    }
}
