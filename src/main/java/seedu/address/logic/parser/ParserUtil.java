package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.cca.CcaName;
import seedu.address.model.cca.Cid;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Pid;
import seedu.address.model.reminder.ReminderName;
import seedu.address.model.reminder.ReminderStartDate;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code CcaName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    // we be kinda repeating code here

    /**
     * Parses a {@code String name} into a {@code CcaName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static CcaName parseCcaName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new CcaName(trimmedName);
    }

    /**
     * Parses a {@code String name} into a {@code ReminderName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static ReminderName parseReminderName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new ReminderName(trimmedName);
    }

    /**
     * Parses a {@code String name} into a {@code ReminderName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static ReminderStartDate parseReminderStartDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDateText = date.trim();
        if (!ReminderStartDate.isValidDate(trimmedDateText)) {
            throw new ParseException(ReminderStartDate.MESSAGE_CONSTRAINTS);
        }
        Date startDate;
        try {
            startDate = ReminderStartDate.parseInputDateFormat.parse(trimmedDateText);
        } catch (java.text.ParseException e) {
            throw new ParseException(ReminderStartDate.PARSE_DATE_CONSTRAINTS);
        }
        return new ReminderStartDate(startDate);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    // todo: Should be able to delete if the usual index works
    /**
     * Parses a {@code String cid} into an {@code int}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code cid} is invalid.
     */
    public static Cid parseCid(String cid) throws ParseException {
        requireNonNull(cid);
        String trimmedCid = cid.trim();
        int intCid = -1;
        try {
            intCid = Integer.parseInt(trimmedCid);
        } catch (Exception e) {
            throw new ParseException("Please input cid as a number");
        } finally {
            if (intCid == -1) {
                throw new ParseException("Please input cid as a number");
            }
            return new Cid(cid);
        }
    }

    /**
     * Parses a {@code String pid} into an {@code int}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code pid} is invalid.
     */
    public static Pid parsePid(String pid) throws ParseException {
        requireNonNull(pid);
        String trimmedPid = pid.trim();
        int intPid = -1;
        try {
            intPid = Integer.parseInt(trimmedPid);
        } catch (Exception e) {
            throw new ParseException("Please input pid as a number");
        } finally {
            if (intPid == -1) {
                throw new ParseException("Please input pid as a number");
            }
            return new Pid(pid);
        }
    }
}
