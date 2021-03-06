package memoryGame;

import view.GameView;

import java.util.*;

public class CardPicturesGenerator {
    private Set<Picture> allPictures;

    public CardPicturesGenerator() {

        allPictures = new HashSet<>(SingletonPictures.getAllPictures());
    }

    public List<Picture> generateRandomPictures() {
        int amount = GameView.ROWS * GameView.COLUMNS;
        List<Picture> cardPictures = new ArrayList<>();
        if (isNotValidCardsAmount(amount)) {
            return cardPictures;
        }
        addPictures(cardPictures, amount / 2);
        Collections.shuffle(cardPictures);
        return cardPictures;
    }

    private void addPictures(List<Picture> cardPictures, int pairs) {
        int count = 0;
        List<Picture> randomPictures = new ArrayList<>(allPictures);
        Collections.shuffle(randomPictures);
        for (Picture picture : randomPictures) {
            cardPictures.add(picture);
            cardPictures.add(picture);
            count++;
            if (count == pairs) {
                break;
            }
        }
    }

    private boolean isNotValidCardsAmount(int amount) {
        return amount % 2 != 0 || amount < 0 || amount > allPictures.size() * 2;
    }
}
