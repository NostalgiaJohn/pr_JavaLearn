import java.util.Scanner;

class Demo7 {
	public static void main(String[] args) {
		int score = 0;
		//Scanner扫描器变量
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入学生的成绩：");
		score = sc.nextInt();
		
		// 用户输入数据合法性判断问题
		if (score < 0 || score > 100) {
			System.out.println("输入错误");
			// 程序退出
			System.exit(0);
		}
		//if - else if
		if (score >= 90) {
			System.out.println("优秀");
		} else if (score >= 80) {
			System.out.println("良好");
		} else if (score >= 70) {
			System.out.println("中等");
		} else if (score >= 60) {
			System.out.println("及格");
		} else {
			System.out.println("不及格");
		}
	}
}