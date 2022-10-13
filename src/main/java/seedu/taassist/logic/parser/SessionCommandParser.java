package seedu.taassist.logic.parser;

import static seedu.taassist.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.taassist.logic.parser.CliSyntax.PREFIX_SESSION;

import seedu.taassist.logic.commands.SessionCommand;
import seedu.taassist.logic.parser.exceptions.ParseException;
import seedu.taassist.model.session.Session;

/**
 * Parses input arguments and creates a new SessionCommand object.
 */
public class SessionCommandParser implements Parser<SessionCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the SessionCommand
     * and returns a SessionCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public SessionCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_SESSION);
        if (!argMultimap.containsPrefixes(PREFIX_SESSION) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SessionCommand.MESSAGE_USAGE));
        }

        Session session = ParserUtil.parseSession(argMultimap.getValue(PREFIX_SESSION).get());

        return new SessionCommand(session);
    }
}