package com.jcboe.home.instruction.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.repo.MessageRepo;
import com.jcboe.home.instruction.response.Message;
import com.jcboe.home.instruction.utilities.Constant;

@ExtendWith(MockitoExtension.class)
class MessageServiceImplTest {

	@Mock
	private MessageRepo messageRepo;

	@InjectMocks
	private MessageServiceImpl messageService;

	@BeforeEach
	void setUp() {
		Constant.setMessageMap(new LinkedHashMap<>());
	}

	@Test
	void testGetMessage_Success() throws Exception {

		Message msg1 = new Message();
		msg1.setMessageRef("MSG_1");
		msg1.setMessageText("Message One");

		Message msg2 = new Message();
		msg2.setMessageRef("MSG_2");
		msg2.setMessageText("Message Two");

		List<Message> messages = Arrays.asList(msg1, msg2);

		when(messageRepo.getMessages("API_REF")).thenReturn(messages);

		assertDoesNotThrow(() -> messageService.getMessage("API_REF"));

		Map<String, String> result = Constant.getMessageMap();

		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals("Message One", result.get("MSG_1"));
		assertEquals("Message Two", result.get("MSG_2"));

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_EmptyList() throws Exception {

		when(messageRepo.getMessages("API_REF"))
				.thenReturn(Collections.emptyList());

		messageService.getMessage("API_REF");

		Map<String, String> result =
				Constant.getMessageMap();

		assertNotNull(result);
		assertEquals(0, result.size());

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_SingleMessage() throws Exception {

		Message message = new Message();
		message.setMessageRef("MSG_1");
		message.setMessageText("Test Message");

		when(messageRepo.getMessages("API_REF")).thenReturn(Collections.singletonList(message));

		messageService.getMessage("API_REF");

		Map<String, String> result = Constant.getMessageMap();

		assertEquals(1, result.size());
		assertEquals("Test Message", result.get("MSG_1"));

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_DuplicateMessageRef() throws Exception {

		Message msg1 = new Message();
		msg1.setMessageRef("MSG_1");
		msg1.setMessageText("First");

		Message msg2 = new Message();
		msg2.setMessageRef("MSG_1");
		msg2.setMessageText("Second");

		when(messageRepo.getMessages("API_REF")).thenReturn(Arrays.asList(msg1, msg2));

		messageService.getMessage("API_REF");

		Map<String, String> result = Constant.getMessageMap();

		assertEquals(1, result.size());
		assertEquals("Second", result.get("MSG_1"));

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_NullMessageRef() throws Exception {

		Message message = new Message();
		message.setMessageRef(null);
		message.setMessageText("Test");

		when(messageRepo.getMessages("API_REF")).thenReturn(Collections.singletonList(message));

		messageService.getMessage("API_REF");

		Map<String, String> result = Constant.getMessageMap();

		assertEquals(1, result.size());
		assertEquals("Test", result.get(null));

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_NullMessageText() throws Exception {

		Message message = new Message();
		message.setMessageRef("MSG_1");
		message.setMessageText(null);

		when(messageRepo.getMessages("API_REF")).thenReturn(Collections.singletonList(message));

		messageService.getMessage("API_REF");

		Map<String, String> result = Constant.getMessageMap();

		assertEquals(1, result.size());
		assertEquals(null, result.get("MSG_1"));

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_NullMessageList() throws Exception {

		when(messageRepo.getMessages("API_REF"))
				.thenReturn(null);

		HomeInstructionException exception =
				assertThrows(
						HomeInstructionException.class,
						() -> messageService.getMessage("API_REF"));

		assertNotNull(exception);
		assertEquals(
				"Database access error",
				exception.getMessage());

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_NullMessageElement() throws Exception {

		when(messageRepo.getMessages("API_REF"))
				.thenReturn(Collections.singletonList(null));

		HomeInstructionException exception =
				assertThrows(
						HomeInstructionException.class,
						() -> messageService.getMessage("API_REF"));

		assertNotNull(exception);

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_SQLException() throws Exception {

		when(messageRepo.getMessages(anyString()))
				.thenThrow(new SQLException("DB Error"));

		HomeInstructionException exception =
				assertThrows(
						HomeInstructionException.class,
						() -> messageService.getMessage("API_REF"));

		assertNotNull(exception);
		assertEquals("DB Error", exception.getMessage());

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_RuntimeException() throws Exception {

		when(messageRepo.getMessages("API_REF"))
				.thenThrow(new RuntimeException("Unexpected error"));

		HomeInstructionException exception =
				assertThrows(
						HomeInstructionException.class,
						() -> messageService.getMessage("API_REF"));

		assertNotNull(exception);
		assertEquals(
				"Unexpected error",
				exception.getMessage());

		verify(messageRepo).getMessages("API_REF");
	}

	@Test
	void testGetMessage_NullApiRef() throws Exception {

		when(messageRepo.getMessages((String) null))
				.thenReturn(Collections.emptyList());

		assertDoesNotThrow(() ->
				messageService.getMessage(null));

		assertNotNull(Constant.getMessageMap());
		assertEquals(0, Constant.getMessageMap().size());

		verify(messageRepo).getMessages((String) null);
	}

	@Test
	void testDefaultConstructor() {

		MessageServiceImpl service = new MessageServiceImpl();

		assertNotNull(service);
	}
}
