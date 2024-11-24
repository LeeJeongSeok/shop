package com.jeongseok.shop.item;

import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
public class FileUploadController {

	private final ItemRepository itemRepository;
	private final FileStore fileStore;


	// 파일 업로드시 파일 사이즈를 유의해야한다. 안그럼 이미지파일이 null값으로 들어옴
	@PostMapping("/")
	public String uploadFile(@ModelAttribute CreateItemDto createItemDto) throws IOException {

		UploadFile attachFile = fileStore.storeFile(createItemDto.getAttachFile());
		List<UploadFile> storeImageFiles = fileStore.storeFiles(createItemDto.getImageFiles());

		// 데이터베이스 저장 (DTO -> 엔티티)
		Item item = new Item();
		item.setItemName(createItemDto.getItemName());
		item.setAttachFile(attachFile);
		item.setImageFiles(storeImageFiles);

		itemRepository.save(item);

		return "파일이 업로드 되었습니다.";
	}
}
