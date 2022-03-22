package chess.view;

import static chess.view.OutputView.*;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static String insertMenu() {
		printGuideInputMenu();
		return scanner.nextLine();
	}
}
