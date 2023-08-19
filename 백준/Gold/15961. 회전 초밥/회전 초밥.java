import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());// 쿠폰 번호
	
		int[] sushi = new int[N];
		int[] type = new int[d+1];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		boolean cp = false;
		for(int i=0; i<k; i++) {
			if(sushi[i%N]==c) cp = true;
			if(type[sushi[i%N]] == 0) cnt++;
			type[sushi[i%N]] += 1;
		}
		
		int max = 0;
		int idx = 0;
		int start = 0;
		int end = (k-1)%N;
		while(true){
			type[sushi[start]]--;
			if(type[sushi[start]]==0) cnt--;
			idx++;
			start = idx%N;
			end = (idx+k-1)%N;
			if(start==0 && end==(k-1)%N) break;
			if(type[sushi[end]]==0) cnt++;
			type[sushi[end]]++;
			if(type[c]!=0) cp = true;
			else cp = false;
			if(cnt >= max) max = (cp) ? cnt : cnt+1;
		}
		System.out.println(max);
	}
}