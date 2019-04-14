package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

/**
 * This interface represents the operations that can be performed after obtaining the list of spots 
 * @author kico
 *
 */
public interface SpotCheckerAction {
	public void execute(SpotChecker spotChecker);
}
