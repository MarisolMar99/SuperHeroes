public class SuperheroRoster
{
    public static void main(String[] args)
    {
        String[] heroNames = {"Groot", "Captian America", "Deadpool" };
        String[] abilities= {"Plant Manipulation", "Strength and agility", "Regeneration and lightning-fast reflexes"};
        int[] powerLevels = {90, 85, 80};

        System.out.println("Superhero Roster: ");

        for (int i = 0; i < heroNames.length; i++)
        {
            System.out.println(heroNames[i] + " - " + abilities[i] + " - Power Level: " + powerLevels[i]);
        }

        System.out.println("\nSearching for Groot: ");
        searchHero(heroNames, abilities, powerLevels, "Groot");

        double avgPower = calculateAveragePower(powerLevels);
        System.out.println("\nAverage Power Level: " + avgPower);

        System.out.println("\nSuperhero Objects: ");
        Superhero[] heroes = new Superhero[heroNames.length];
        for(int i = 0; i < heroNames.length; i++)
        {
            heroes[i] = new Superhero(heroNames[i], abilities[i], powerLevels[i]);
            heroes[i].displayHero();
        }

        System.out.println("\nHeroes Sorted by Power Level (Decreasing Order): ");
        sortHeroesByPower(heroes);
            for (Superhero hero : heroes)
            {
                hero.displayHero();
            }

    }

    public static void searchHero(String [] names, String[] abilities, int[] powerLevels, String target)
    {
        boolean found = false;
        for (int i = 0; i < names.length; i++)
        {
            if (names[i].equalsIgnoreCase(target))
            {
                System.out.println("Hero found: " + names[i] + " - " + abilities[i] + " - Power Level: " + powerLevels[i]);
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Hero not found: " + target);
        }
    }

    public static double calculateAveragePower(int[] powerLevels)
    {
        int sum = 0;
        for(int power: powerLevels)
        {
            sum += power;
        }
        return (double) sum/ powerLevels.length;
    }

    public static void sortHeroesByPower(Superhero[] heroes)
    {
        for(int i = 0; i < heroes.length - 1; i++)
        {
            for(int j = i + 1; j < heroes.length; j++)
            {
                if (heroes[j].getPowerLevel() > heroes[i].getPowerLevel())
                {
                    Superhero temp = heroes[i];
                    heroes[i] = heroes[j];
                    heroes[j] = temp;
                }
            }
        }
    }
}




