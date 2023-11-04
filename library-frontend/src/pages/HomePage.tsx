import { Grid, GridItem, Show } from "@chakra-ui/react";
import BookList from "../components/BookList";
import CategoryList from "../components/CategoryList";
import { Book } from "../entities/Book";

export interface BookQuery {
  book: Book;
  categoryId: number;
}

function HomePage() {
  return (
    <>
      <Grid
        templateAreas={{
          base: `"nav" "main"`,
          lg: `"nav nav" "aside main"`,
        }}
        templateColumns={{
          base: "1fr",
          lg: "200px 1fr",
        }}
      >
        <Show above="lg">
          <GridItem area="aside" paddingX={5}>
            <CategoryList />
          </GridItem>
        </Show>
        <GridItem area="main">
          <BookList />
        </GridItem>
      </Grid>
    </>
  );
}

export default HomePage;
