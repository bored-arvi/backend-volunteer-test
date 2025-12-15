package com.gdg.canteen.service.impl;

import com.gdg.canteen.dto.MenuItemRequestDTO;
import com.gdg.canteen.dto.MenuItemResponseDTO;
import com.gdg.canteen.entity.MenuItem;
import com.gdg.canteen.exception.ResourceNotFoundException;
import com.gdg.canteen.repository.MenuItemRepository;
import com.gdg.canteen.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public MenuItemResponseDTO createMenuItem(MenuItemRequestDTO requestDTO) {
        MenuItem menuItem = mapToEntity(requestDTO);
        MenuItem savedItem = menuItemRepository.save(menuItem);
        return mapToResponseDTO(savedItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItemResponseDTO> getAllMenuItems() {
        return menuItemRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MenuItemResponseDTO getMenuItemById(Long id) {
        MenuItem menuItem = findMenuItemById(id);
        return mapToResponseDTO(menuItem);
    }

    @Override
    public MenuItemResponseDTO updateMenuItem(Long id, MenuItemRequestDTO requestDTO) {
        MenuItem existingItem = findMenuItemById(id);
        
        existingItem.setName(requestDTO.getName());
        existingItem.setPrice(requestDTO.getPrice());
        existingItem.setCategory(requestDTO.getCategory());
        existingItem.setAvailability(requestDTO.getAvailability());
        
        MenuItem updatedItem = menuItemRepository.save(existingItem);
        return mapToResponseDTO(updatedItem);
    }

    @Override
    public void deleteMenuItem(Long id) {
        MenuItem menuItem = findMenuItemById(id);
        menuItemRepository.delete(menuItem);
    }

    private MenuItem findMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Menu item not found with id: " + id));
    }

    private MenuItem mapToEntity(MenuItemRequestDTO dto) {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(dto.getName());
        menuItem.setPrice(dto.getPrice());
        menuItem.setCategory(dto.getCategory());
        menuItem.setAvailability(dto.getAvailability());
        return menuItem;
    }

    private MenuItemResponseDTO mapToResponseDTO(MenuItem menuItem) {
        MenuItemResponseDTO dto = new MenuItemResponseDTO();
        dto.setId(menuItem.getId());
        dto.setName(menuItem.getName());
        dto.setPrice(menuItem.getPrice());
        dto.setCategory(menuItem.getCategory());
        dto.setAvailability(menuItem.getAvailability());
        return dto;
    }
}