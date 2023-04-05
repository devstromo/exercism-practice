class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake | archerIsAwake | prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake & !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        if (prisonerIsAwake && !petDogIsPresent && (knightIsAwake || archerIsAwake))
            return false;
        if (prisonerIsAwake && petDogIsPresent && !knightIsAwake && archerIsAwake)
            return false;
        if (!prisonerIsAwake && petDogIsPresent && !knightIsAwake && archerIsAwake)
            return false;
        if (prisonerIsAwake && petDogIsPresent && knightIsAwake && !archerIsAwake)
            return true;
        return (petDogIsPresent || prisonerIsAwake) && !(knightIsAwake && archerIsAwake);
    }
}
