package per.zs.studyScala.studyFirst;

/** 
* @author zs 
* @version 创建时间：2019年6月25日 下午4:04:12 
* @Description 类描述 
*/
public class GirlFriends {
	private String name;
	private int age;
	private Double weight;
	private Double height;
	private String measurements;
	private String describe;
	public GirlFriends(String name, int age, Double weight, Double height, String measurements, String describe) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.measurements = measurements;
		this.describe = describe;
	}
	
	@Override
	public String toString() {
		return "GirlFriends [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height
				+ ", measurements=" + measurements + ", describe=" + describe + "]";
	}

//	GirlFriends girlFriends_1 = new GirlFriends("鞠婧祎", 25, 46.0, 159.0, "78-54.5-80", "可爱的小鞠");
//	GirlFriends girlFriends_2 = new GirlFriends("", 18, 50.0, 160.0, "", "");
//	GirlFriends girlFriends_3 = new GirlFriends("", 18, 50.0, 160.0, "", "");
//	GirlFriends girlFriends_4 = new GirlFriends("", 18, 50.0, 160.0, "", "");
	Short a = 24;
	Customer customer = new Customer(1, "zs", 'a', a, "13548429131", "sheng.zhong@changhong.com");
}
