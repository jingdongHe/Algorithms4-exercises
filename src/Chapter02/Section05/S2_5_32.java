package Chapter02.Section05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
class EightPuzzle implements Comparable{
    private int[] num = new int[9];
    private int depth;                    //��ǰ����ȼ��ߵ���ǰ״̬�Ĳ���
    private int evaluation;                //����ʼ״̬��Ŀ�����С����ֵ
    private int misposition;            //��Ŀ�����С����
    private EightPuzzle parent;            //��ǰ״̬�ĸ�״̬
    public int[] getNum() {
        return num;
    }
    public void setNum(int[] num) {
        this.num = num;
    }
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getEvaluation() {
        return evaluation;
    }
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
    public int getMisposition() {
        return misposition;
    }
    public void setMisposition(int misposition) {
        this.misposition = misposition;
    }
    public EightPuzzle getParent() {
        return parent;
    }
    public void setParent(EightPuzzle parent) {
        this.parent = parent;
    }
    
    /**
     * �жϵ�ǰ״̬�Ƿ�ΪĿ��״̬
     * @param target
     * @return
     */
    public boolean isTarget(EightPuzzle target){
        return Arrays.equals(getNum(), target.getNum());
    }
    
    /**
     * ��f(n) = g(n)+h(n);
     * ��ʼ��״̬��Ϣ
     * @param target
     */
    public void init(EightPuzzle target){
        int temp = 0;
        for(int i=0;i<9;i++){
            if(num[i]!=target.getNum()[i])
                temp++;
        }
        this.setMisposition(temp);
        if(this.getParent()==null){
            this.setDepth(0);
        }else{
            this.depth = this.parent.getDepth()+1;
        }
        this.setEvaluation(this.getDepth()+this.getMisposition());
    }
    
    /**
     * ������ֵ���ж��Ƿ��н�
     * @param target
     * @return �н⣺true �޽⣺false
     */
    public boolean isSolvable(EightPuzzle target){
        int reverse = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<i;j++){
                if(num[j]>num[i])
                    reverse++;
                if(target.getNum()[j]>target.getNum()[i])
                    reverse++;
            }
        }
        if(reverse % 2 == 0)
            return true;
        return false;
    }
    @Override
    public int compareTo(Object o) {
        EightPuzzle c = (EightPuzzle) o;
        return this.evaluation-c.getEvaluation();//Ĭ������Ϊf(n)��С��������
    }
    /**
     * @return ����0�ڰ������е�λ��
     */
    public int getZeroPosition(){
        int position = -1;
        for(int i=0;i<9;i++){
            if(this.num[i] == 0){
                position = i;
            }
        }
        return position;
    }
    /**
     * 
     * @param open    ״̬����
     * @return �жϵ�ǰ״̬�Ƿ������open����
     */
    public int isContains(ArrayList<EightPuzzle> open){
        for(int i=0;i<open.size();i++){
            if(Arrays.equals(open.get(i).getNum(), getNum())){
                return i;
            }
        }
        return -1;
    }
    /**
     * 
     * @return С��3�Ĳ������Ʒ���false
     */
    public boolean isMoveUp() {
        int position = getZeroPosition();
        if(position<=2){
            return false;
        }
        return true;
    }
    /**
     * 
     * @return ����6����false
     */
    public boolean isMoveDown() {
        int position = getZeroPosition();
        if(position>=6){
            return false;
        }
        return true;
    }
    /**
     * 
     * @return 0��3��6����false
     */
    public boolean isMoveLeft() {
        int position = getZeroPosition();
        if(position%3 == 0){
            return false;
        }
        return true;
    }
    /**
     * 
     * @return 2��5��8�������Ʒ���false
     */
    public boolean isMoveRight() {
        int position = getZeroPosition();
        if((position)%3 == 2){
            return false;
        }
        return true;
    }
    /**
     * 
     * @param move 0���ϣ�1���£�2����3����
     * @return �����ƶ����״̬
     */
    public EightPuzzle moveUp(int move){
        EightPuzzle temp = new EightPuzzle();
        int[] tempnum = (int[])num.clone();
        temp.setNum(tempnum);
        int position = getZeroPosition();    //0��λ��
        int p=0;                            //��0��λ�õ�λ��
        switch(move){
            case 0:
                p = position-3;
                temp.getNum()[position] = num[p];
                break;
            case 1:
                p = position+3;
                temp.getNum()[position] = num[p];
                break;
            case 2:
                p = position-1;
                temp.getNum()[position] = num[p];
                break;
            case 3:
                p = position+1;
                temp.getNum()[position] = num[p];
                break;
        }
        temp.getNum()[p] = 0;
        return temp;
    }
    /**
     * ���հ�����ĸ�ʽ���
     */
    public void print(){
        for(int i=0;i<9;i++){
            if(i%3 == 2){
                System.out.println(this.num[i]);
            }else{
                System.out.print(this.num[i]+"  ");
            }
        }
    }
    /**
     * �����е����״̬
     */
    public void printRoute(){
        EightPuzzle temp = null;
        int count = 0;
        temp = this;
        while(temp!=null){
            temp.print();
            System.out.println("----------�ָ���----------");
            temp = temp.getParent();
            count++;
        }
        System.out.println("��������"+(count-1));
    }
    /**
     * 
     * @param open open��
     * @param close close��
     * @param parent ��״̬
     * @param target Ŀ��״̬
     */
    public void operation(ArrayList<EightPuzzle> open,ArrayList<EightPuzzle> close,EightPuzzle parent,EightPuzzle target){
        if(this.isContains(close) == -1){
            int position = this.isContains(open);
            if(position == -1){
                this.parent = parent;
                this.init(target);
                open.add(this);
            }else{
                if(this.getDepth() < open.get(position).getDepth()){
                    open.remove(position);
                    this.parent = parent;
                    this.init(target);
                    open.add(this);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        //����open��
        ArrayList<EightPuzzle> open = new ArrayList<EightPuzzle>();
        ArrayList<EightPuzzle> close = new ArrayList<EightPuzzle>();
        EightPuzzle start = new EightPuzzle();
        EightPuzzle target = new EightPuzzle();
        
        //BufferedReader br = new BufferedReader(new FileReader("./input.txt") );
        String lineContent = null;
        int stnum[] = {2,1,6,4,0,8,7,5,3};
        int tanum[] = {1,2,3,8,0,4,7,6,5};
        int order = 0;
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader("input.txt") );
            while((lineContent=br.readLine())!=null){
                String[] str = lineContent.split(",");
                for(int i = 0 ;i<str.length;i++){
                    if(order==0)
                        stnum[i] = Integer.parseInt(str[i]);
                    else 
                        tanum[i] = Integer.parseInt(str[i]);
                }
                order++;
            }
        } catch (NumberFormatException e) {
            System.out.println("���������ļ��ĸ�ʽ�����磺2,1,6,4,0,8,7,5,3 ���� 1,2,3,8,0,4,7,6,5");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("��ǰĿ¼����input.txt�ļ���");
            e.printStackTrace();
        }
        start.setNum(stnum);
        target.setNum(tanum);
        long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
        if(start.isSolvable(target)){
            //��ʼ����ʼ״̬
            start.init(target);            
            open.add(start);
            while(open.isEmpty() == false){
                Collections.sort(open);            //����evaluation��ֵ����
                EightPuzzle best = open.get(0);    //��open����ȡ����С��ֵ��״̬���Ƴ�open��
                open.remove(0);
                close.add(best);
                if(best.isTarget(target)){            
                    //���
                    best.printRoute();
                    long end=System.currentTimeMillis(); //��ȡ����ʱ��  
                    System.out.println("��������ʱ�䣺 "+(end-startTime)+"ms");
                    System.exit(0);
                }
                int move;
                //��best״̬������չ�����뵽open����
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if(best.isMoveUp()){
                    move = 0;
                    EightPuzzle up = best.moveUp(move);
                    up.operation(open, close, best, target);
                }
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if(best.isMoveDown()){
                    move = 1;
                    EightPuzzle up = best.moveUp(move);
                    up.operation(open, close, best, target);
                }
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if(best.isMoveLeft()){
                    move = 2;
                    EightPuzzle up = best.moveUp(move);
                    up.operation(open, close, best, target);
                }
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if(best.isMoveRight()){
                    move = 3;
                    EightPuzzle up = best.moveUp(move);
                    up.operation(open, close, best, target);
                }
                
            }
        }else 
            System.out.println("û�н⣬���������롣");
    }
    
}
public class S2_5_32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ο���https://www.cnblogs.com/beilin/p/5981483.html
		// �������Ǿ���� ������ ���⣬��ͼ����ʰʱͳһ���
	}

}