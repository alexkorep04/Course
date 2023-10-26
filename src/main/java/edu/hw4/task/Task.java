package edu.hw4.task;


import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Task {
    public Task() {
    }

    public List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).collect(Collectors.toList());
    }

    private List<Animal> sortAnimalsByWeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::weight).reversed()).collect(Collectors.toList());
    }

    public List<Animal> chooseKMostHeavyAnimals(List<Animal> animals, int k) {
        return sortAnimalsByWeight(animals).stream().limit(k).collect(Collectors.toList());
    }

    public Map<Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Type, List<Animal>> typeListMap =  animals.stream().collect(Collectors.groupingBy(Animal::type));
        Map<Type, Integer> map = new HashMap<>();
        for (Map.Entry<Type, List<Animal>> entry: typeListMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue().size());
        }
        return map;
    }

    public Animal findAnimalWithLongName(List<Animal> animals) {
        return animals.stream()
            .max((a1, a2) -> a1.name().length() - a2.name().length())
            .orElse(null);
    }

    public Sex countAnimalsWithPopularSex(List<Animal> animals) {
        List<Animal> m = animals.stream().filter(x -> x.sex() == Sex.M).toList();
        List<Animal> f = animals.stream().filter(x -> x.sex() == Sex.F).toList();
        if (m.size() > f.size()) {
            return Sex.M;
        }
        return Sex.F;
    }

    public Map<Type, Animal> getHeaviestAnimalOfEveryType(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(Animal::weight)),
                animal -> animal.orElse(null)
            )
        ));
    }

    public Animal getKHeaviestAnimal(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::age).reversed()).limit(k).toList().get(k - 1);
    }

    public Optional<Animal> getHeaviestAnimalAmongLessThanKCentimetre(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k).max(Comparator.comparingInt(Animal::weight));
    }

    public int countAmountOfPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public List<Animal> getListOfAnimalsThatNoEqualAgeAndAmountOfPaws(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.paws() != animal.age()).toList();
    }

    @SuppressWarnings("MagicNumber")
    public List<Animal> getAnimalsAbleToBite(List<Animal> animals) {
        return animals.stream().filter(animal -> (animal.height() > 100 &&  animal.bites())).toList();
    }

    public long countAmountOfAnimalsWithWeightMoreHeight(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

    public List<Animal> getAnimalsNameOfWhichContainsTwoWords(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name()
            .split(" ").length > 2).toList();
    }

    public boolean isDogHasHeightMoreK(List<Animal> animals, int k) {
            return animals.stream().filter(animal -> animal.type() == Type.DOG && animal.height() > k)
                .toList().size() > 0;
    }

    public Map<Type, Integer> findSummaryWeightOfAnimalsByTypeFromAgeKToL(List<Animal> animals, int k, int l) {
        return animals.stream().filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
    }

    public List<Animal> sortByParameters(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex)
            .thenComparing(Animal::name)).toList();
    }

    public boolean areSpidersBiteMoreOftenThanDogs(List<Animal> animals) {
        double cntSpiders = (double) animals.stream().filter(animal -> animal.type() == Type.SPIDER).count();
        double cntDogs = (double) animals.stream().filter(animal -> animal.type() == Type.DOG).count();
        double cntSpidersBite = (double) animals.stream()
            .filter(animal -> animal.bites() && animal.type() == Type.SPIDER)
            .count();
        double cntDogsBite = (double) animals.stream()
            .filter(animal -> animal.bites() && animal.type() == Type.DOG).count();
        return cntSpidersBite / cntSpiders > cntDogsBite / cntDogs;
    }

    public Animal getTheHeaviestFish(List<Animal> animals1, List<Animal> animals2) {
        List<List<Animal>> allAnimals = Arrays.asList(animals1, animals2);
        return allAnimals.stream().flatMap(List::stream).filter(animal -> animal.type() == Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).get();
    }

    public Map<String, Set<ValidationError>> getAnimalsWithErrors(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, Validation::validateAnimal,
            (existing, replacement) -> {
                existing.addAll(replacement);
                return existing;
            }));
    }

    public Map<String, String> getAnimalsWithErrorsWithFields(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                NewValidation::getValidationErrors,
                (existing, replacement) -> existing
            ));
    }
}
