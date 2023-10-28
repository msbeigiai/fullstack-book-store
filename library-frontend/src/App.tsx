import { Grid, GridItem } from "@chakra-ui/react";
import BookList from "./components/BookList";
import { Book } from "./entities/Book";
import NavBar from "./components/NavBar";
import { useState } from "react";
import CategoryList from "./components/CategoryList";

export interface BookQuery {
  book: Book;
  category: string;
}

function App() {
  const [bookQuery, setBookQuery] = useState<BookQuery>({} as BookQuery);
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
        <GridItem area="nav">
          <NavBar />
        </GridItem>
        <GridItem area="aside" paddingX={5}>
          <CategoryList
            onSelectCategory={(category) => setBookQuery({ ...bookQuery, category })}
          />
        </GridItem>
        <GridItem area="main">
          <BookList />
        </GridItem>
      </Grid>
    </>
  );
}

export default App;
