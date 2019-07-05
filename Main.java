package challenge;

import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static List<Player> playerList = new ArrayList<Player>();

	public static void main(String[] args) {

	String csvFile = "/Users/britoviana/codenation/java-3/src/main/resources/data.csv";
	String line = "";
	String cvsSplitBy = ",";

	try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

		String cabecalho = br.readLine();

			while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] player = line.split(cvsSplitBy);


					//String[] player = Arrays.asList(line.split(cvsSplitBy));

					//System.out.println(player[2] + " has " + player[6]);

					//if (player[18].length() > 0) System.out.println(Double.parseDouble(player[18]));

					if (player.length > 0){
						Player plyr;
						if (player[18].length() > 0) {
							plyr = new Player(player[2], player[3], Integer.parseInt(player[6]), player[8], player[14], Double.parseDouble(player[18]), Double.parseDouble(player[17]));
						} else {
							plyr = new Player(player[2], player[3], Integer.parseInt(player[6]), player[8], player[14], 0.0, Double.parseDouble(player[17]));
						}
						playerList.add(plyr);
					}
					//Double[] release_clause = new Double[eur_release_clause.size()];
					//for (int i = 1; i < eur_release_clause.size(); i++)
   					//release_clause[i] = Double.parseDouble(eur_release_clause.get(i));

			}

			int result = new Main().q1();
			System.out.println(result);
			int result2 = new Main().q2();
			System.out.println(result2);
			List<String> result3 = new Main().q3();
			System.out.println(result3);
			List<String> result4 = new Main().q4();
			System.out.println(result4);
			List<String> result5 = new Main().q5();
			System.out.println(result5);




			/*for(Player p : playerList)
            {
                System.out.println(p.toString());
            }*/




	} catch (IOException e) {
			e.printStackTrace();
	}
}
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {

			List<String> nationality = new ArrayList<String>();

			playerList.forEach(item->{
			if (!nationality.contains(item.getNationality())) nationality.add(item.getNationality());
			});


		return nationality.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {

		List<String> club = new ArrayList<String>();

		playerList.forEach(item->{
			if (!club.contains(item.getClub()) && item.getClub() != "") club.add(item.getClub());
			});

		return club.size();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<String> FirstNames = new ArrayList<String>();

		for(int i = 0; i < 20; i++) FirstNames.add(playerList.get(i).getName());

		return FirstNames;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		//List<Double> release_clause = new ArrayList<Double>();
		List<String> ten_release_clauses = new ArrayList<String>();

		//playerList.forEach(item->{
		//	release_clause.add(item.getReleaseClause());
		//	});

		//Collections.sort(release_clause);
		//Collections.reverse(release_clause);

		Collections.sort(playerList, Collections.reverseOrder(Comparator.comparingDouble(j -> j.getReleaseClause())));


		//for(int i = 0; i < 10; i++) ten_release_clauses.add(release_clause.get(i).toString());
		for(int i = 0; i < 10; i++) ten_release_clauses.add(playerList.get(i).getName());
				
			//	release_clause.forEach(item->{
			//		System.out.println(String.format("EUR %.2f M", item / 1000000.0));
			//	});
		return ten_release_clauses;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		List<String> oldest_players = new ArrayList<String>();

		Collections.sort(playerList,
                    Comparator.nullsLast(
                            Comparator.comparing(Player::getBirthDate, Comparator.nullsLast(Comparator.naturalOrder()))
                                    .thenComparingDouble(Player::getWage)
                    ));

			for (int i = 0; i < 10; i++) oldest_players.add(playerList.get(i).getName());

		return oldest_players;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {


		return null;
	}

}
