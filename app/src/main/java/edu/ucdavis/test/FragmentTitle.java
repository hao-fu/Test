package edu.ucdavis.test;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class FragmentTitle extends ListFragment {
    public final static String TAG = "FragmentTitle";
	private final static String title[] = { "龙骑士", "死灵骑士", "死神来了", "第一滴血" };
	private final static String content[] = {
			"　曾经和平富饶的国度阿拉盖西亚，如今陷在邪恶国王（约翰·马尔科维奇 John Malkovich 饰）的暴政统治下，期待神灵解救敢怒不敢言的人民。一日，农家少年伊拉贡（艾德·斯皮尔斯 Ed Speleers 饰）在林中拾获一枚奇石，不想竟是一枚龙卵，孵出一只蓝色飞龙。伊拉贡为小龙取名“萨菲拉”，遇到先知布鲁姆（杰瑞米·艾恩斯 Jeremy Irons 饰）后，才明白这是一场怎样的机缘——曾经守护这片土地的龙骑士应该回来了，带领人民找回自由。在布鲁姆的指导下，伊拉贡开始学习剑术和驭龙技巧，慢慢从一个普通少年成长为担当重任的龙骑士，前路危险重重，前路通向光明…… ",
			"莫罗（伊德瑞斯·艾尔巴 Idris Elba 饰）请求布雷斯把小孩丹尼带来神殿以避免恶魔夺取他的灵魂，作为回报他将驱除布雷斯身上的诅咒。丹尼是魔鬼罗尔科的儿子，罗尔科为了把自己的魔力植入儿子体内正派卡里跟追踪逃跑途中的母子两人。正当母子俩被困在采石场的时候，布雷斯到来，他体内的天使爆发了出来，压制住了卡里根。他变成了恶灵骑士，毫不手软的把对手撕成碎片。当战争结束时，三人前往神殿，同时，罗尔科也救醒了死亡边缘的卡里根，并赋予他更可怕的摧毁力，让他再去把丹尼找回来。 在神殿里，莫罗履行协议把布雷斯体内的扎萨罗斯驱赶了出来。但正当他做法时，神殿的牧师试图杀死丹尼——他认为丹尼就是恶魔。还没等他们行动，卡里根就到了。把丹尼带去见了",
			"某公司组织一次远游，虽然员工们各怀心事，不过他们还是踏上了欢乐的旅途。在经过一座巨大的吊桥时，年轻人山姆（Nicholas D'Agosto 饰）突然看到幻象，幻象中大桥开始垮塌，包括他、同事、朋友在内无数人在这起事故中遇难。当他从幻象中醒来时，周边的种种迹象表明那场灾难即将到来。慌乱之中，他和朱莉（艾玛·贝尔 Emma Bell 饰）、皮特（Miles Fisher 饰）、坎蒂丝（Ellen Wroe 饰）、奥利维亚（Jacqueline MacInnes Wood 饰）等8个人下了车。灾难随即发生，山姆等人成为车上仅有的幸存者。 但是命运并未偏袒这几名幸运儿，死神仍时刻逡巡在他们的周围。死神来了，无论逃到天涯海角也没有用…",
			"　退伍军人兰博（西尔维斯特•史泰龙Sylvester Stallone 饰）从越南回国，他回到已显得陌生的原居小镇，当地警长（布莱恩•丹内利 Brian Dennehy 饰）看到这个退伍军人的第一眼起，就开始对兰博百般挑剔，甚至将他带回警局肆意侮辱，不堪忍受责打的兰博袭警之后逃跑。警长召集大批警察展开对兰博的追捕，兰博逃至荒山野林之中，不断用自己在越战中掌握的游击战术对警察展开反击，他抢劫了一辆武器运输车返回小镇烧毁了商店，法律和武器都不能阻止兰博了。兰博在越战时的长官上校（理查德•克里纳 Richard Crenna 饰）出现，劝说兰博放下枪械，愤懑已久的兰博吼出了自己的困惑与不甘…… " };

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "Item: " + 0, Toast.LENGTH_SHORT).show();
		getListView().setBackgroundColor(
				getResources().getColor(android.R.color.darker_gray));
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, title));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_title, container, false);
		return view;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		OnTitleClickListener listener = (OnTitleClickListener) (getActivity());
		listener.onTitleClick(content[position]);
		sendMessage();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	public interface OnTitleClickListener {
        void onTitleClick(String content);
	}

	private void sendMessage() {
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage("+49", null, "damn", null, null);  //sink, leak
	}

    public static FragmentTitle getInstance() {
        FragmentTitle fragmentTitle = new FragmentTitle();
        return fragmentTitle;
    }

}
