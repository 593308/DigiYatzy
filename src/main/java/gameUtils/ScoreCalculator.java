package gameUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import gameClasses.Player;
import gameClasses.YatzyGame;

public class ScoreCalculator {
	
	private List<Function<List<Integer>, Integer>> scoreFunctions;
	
	public ScoreCalculator() {
		scoreFunctions = new ArrayList<Function<List<Integer>, Integer>>();
		
		Function <List<Integer>, Integer> ones = d -> {
			return d.stream().filter(o -> o == 1).mapToInt(Integer::intValue).sum();
		};
		Function <List<Integer>, Integer> twos = d -> {
			return d.stream().filter(o -> o == 2).mapToInt(Integer::intValue).sum();
		};
		Function <List<Integer>, Integer> threes = d -> {
			return d.stream().filter(o -> o == 3).mapToInt(Integer::intValue).sum();
		};
		Function <List<Integer>, Integer> fours = d -> {
			return d.stream().filter(o -> o == 4).mapToInt(Integer::intValue).sum();
		};
		Function <List<Integer>, Integer> fives = d -> {
			return d.stream().filter(o -> o == 5).mapToInt(Integer::intValue).sum();
		};
		Function <List<Integer>, Integer> sixes = d -> {
			return d.stream().filter(o -> o == 6).mapToInt(Integer::intValue).sum();
		};
		Function <List<Integer>, Integer> onePair = d -> {
			int[] valueCounts =  getValueCounts(d);
			List<Integer> selectedPairValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] >= 2)
					selectedPairValues.add(i);
			return selectedPairValues.stream().max((a, b) -> a.compareTo(b)).get() * 2;
		};
		Function <List<Integer>, Integer> twoPairs = d -> {
			int[] valueCounts =  getValueCounts(d);
			List<Integer> selectedPairValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] >= 2)
					selectedPairValues.add(i);
			if (selectedPairValues.size() < 2)
				return 0;
			return (selectedPairValues.get(selectedPairValues.size() - 1) + selectedPairValues.get(selectedPairValues.size() - 2)) * 2;
		};
		Function <List<Integer>, Integer> threeOfAKind = d -> {
			int[] valueCounts =  getValueCounts(d);
			List<Integer> selectedGroupValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] >= 3)
					selectedGroupValues.add(i);
			return selectedGroupValues.stream().max((a, b) -> a.compareTo(b)).get() * 3;
		};
		Function <List<Integer>, Integer> fourOfAKind = d -> {
			int[] valueCounts =  getValueCounts(d);
			List<Integer> selectedGroupValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] >= 4)
					selectedGroupValues.add(i);
			return selectedGroupValues.stream().max((a, b) -> a.compareTo(b)).get() * 4;
		};
		Function <List<Integer>, Integer> smallStraight = d -> {
			for (int i = 1; i <= 5; i++)
				if (!d.contains(i))
					return 0;
			return 15;
		};
		Function <List<Integer>, Integer> largeStraight = d -> {
			for (int i = 2; i <= 6; i++)
				if (!d.contains(i))
					return 0;
			return 20;
		};
		Function <List<Integer>, Integer> fullHouse = d -> {
			int[] valueCounts =  getValueCounts(d);
			List<Integer> selectedPairValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] <= 2)
					selectedPairValues.add(i);
			List<Integer> selectedGroupValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] <= 3)
					selectedGroupValues.add(i);
			int threeValue = selectedGroupValues.stream().max((a, b) -> a.compareTo(b)).get();
			selectedPairValues.remove((Integer)threeValue);
			int twoValue = selectedPairValues.stream().max((a, b) -> a.compareTo(b)).get();
			return twoValue * 2 + threeValue * 3;
		};
		Function <List<Integer>, Integer> chance = d -> {
			return d.stream().mapToInt(i -> i).sum();
		};
		Function <List<Integer>, Integer> yatzy = d -> {
			int[] valueCounts =  getValueCounts(d);
			List<Integer> selectedGroupValues = new ArrayList<>();
			for (int i = 0; i < valueCounts.length; i++)
				if (valueCounts[i] >= 5)
					selectedGroupValues.add(i);
			if (selectedGroupValues.size() == 0)
				return 0;
			return 50;
		};
		
		scoreFunctions.add(null);
		scoreFunctions.add(ones);
		scoreFunctions.add(twos);
		scoreFunctions.add(threes);
		scoreFunctions.add(fours);
		scoreFunctions.add(fives);
		scoreFunctions.add(sixes);
		scoreFunctions.add(onePair);
		scoreFunctions.add(twoPairs);
		scoreFunctions.add(threeOfAKind);
		scoreFunctions.add(fourOfAKind);
		scoreFunctions.add(smallStraight);
		scoreFunctions.add(largeStraight);
		scoreFunctions.add(fullHouse);
		scoreFunctions.add(chance);
		scoreFunctions.add(yatzy);
	}
	
	public int calculateScore(List<Integer> diceValues, int round) {
		return scoreFunctions.get(round).apply(diceValues);
	}
	
	public int calculateBonusScore(Player p) {
		if (p.getOnesScore() +
				p.getTwosScore() +
				p.getThreesScore() +
				p.getFoursScore() +
				p.getFivesScore() +
				p.getSixesScore() >= 63)
			return 50;
		return 0;
	}
	
	private int[] getValueCounts(List<Integer> dice){
		int[] results = new int[7];
		for (int i = 0; i < dice.size(); i++) {
			results[dice.get(i)]++;
		}
		return results;
	}

}
