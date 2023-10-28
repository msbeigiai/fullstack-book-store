import { Button, List, ListItem, Spinner, Text } from "@chakra-ui/react";
import useCategories from "../hooks/useCategories";


interface Props {
  setSelectedCategoryId: (id: number) => void;
}

const CategoryList = ({ setSelectedCategoryId }: Props) => {

  const { data, isLoading, error } = useCategories();

  if (isLoading) return <Spinner />

  if (error) return <Text>{error.message}</Text>

  return (
    <List>
      {data?.results.map((category) => (
        <ListItem key={category.id}>
          <Button
            whiteSpace="normal"
            textAlign="left"
            fontSize="lg"
            variant="link"
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
