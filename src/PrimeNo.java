
public class PrimeNo {

	public static void main(String[] args) {
 
        // 1. reverse
        String i1 = "abcd";
        String i2 = "abcde";
 
        char[] ch = i1.toCharArray();
        char tp = '0';
        // temp,for swap
        int lastIdx = i1.length() - 1;
        int lastIdxx = i2.length() - 1;
 
        for (int idx = 0; idx < (i1.length() / 2); idx++) {
            // for (int idxx = i1.length() - 1; idxx > (i1.length() / 2); idxx--) {
            // if�� �� ���̴ٴ� �ٸ��� ���̵�� �����
        	//����� �� for�� �Ⱦ��̴ٰ� ��
                tp = ch[idx];   ch[idx] = ch[lastIdx - idx];    ch[lastIdx - idx] = tp;
            // }
 
        }
 
        for (char c : ch) {
            System.out.print(c + " ");
        }
        System.out.println();
         
        ch = i2.toCharArray();
        for (int idx = 0; idx < (i2.length() / 2); idx++) {
            tp = ch[idx];   ch[idx] = ch[lastIdxx - idx];   ch[lastIdxx - idx] = tp;
        }
 
        for (char c : ch) {
            System.out.print(c + " ");
        }
        System.out.println();
 
        // 2. prime no
        int temp = 2;
        int j;
 
        for (int i = 2; i <= 100; i++) {
            for (j = 2; j <= i; j++) {
 
                if (i % j == 0 || i % temp == 0) {
                    // :�Ҽ��� �����ϴ� �ٸ��� �˰��� ���̵�� ��� ��������. (i != 2) &&
                    break;
                }
            }
            if (i == j) {
                temp = i;
                // �Ʒ��� �δ�...�ٷ� Ż���ؼ� ����� �ȵż� �׳� j �ٱ����� ��
                System.out.print(i + " ");
            }
 
        }
    }

}
