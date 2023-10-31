import { Button, List, ListItem, Spinner, Text } from "@chakra-ui/react";
import useCategories from "../hooks/useCategories";
import useBookQueryStore from "../store";

const CategoryList = () => {
  const { data, isLoading, error } = useCategories();
  const selectedCategoryId = useBookQueryStore((s) => s.bookQuery.categoryId);
  const setSelectedCategoryId = useBookQueryStore((s) => s.setCategoryId);

  if (isLoading) return <Spinner />;
  if (error) return <Text>{error.message}</Text>;

  return (
    <List>
      <Button
        onClick={() => setSelectedCategoryId(0)}
        fontWeight={selectedCategoryId === 0 ? "bold" : ""}
        whiteSpace="normal"
        variant="link"
      >
        All Books
      </Button>
      {data?.results.map((category) => (
        <ListItem key={category.id}>
          <Button
            whiteSpace="normal"
            textAlign="left"
            fontSize="lg"
            variant="link"
            fontWeight={selectedCategoryId === category.id ? "bold" : ""}
            onClick={() => setSelectedCategoryId(category.id)}
          >
            {category.name}
          </Button>
        </ListItem>
      ))}
    </List>
  );
};

export default CategoryList;
