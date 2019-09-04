import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "I");
        map.put(3, "love");
        map.put(5, "java");
        System.out.println(map);
        //����key��ȡvalue
        System.out.println(map.get(2));
        //map �в����ڵ�key���� null
        System.out.println(map.get(101));
        //map�в����ڵ�key ����Ĭ��ֵ
        System.out.println(map.getOrDefault(101,"like"));
        //Ĭ��ֵ�������map��
        System.out.println(map);

        //��ӡ����key
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        //��ӡ����value
        for (String value : map.values()) {
            System.out.println(value);
        }
        //�� key - value ӳ���ϵ��ӡ
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
