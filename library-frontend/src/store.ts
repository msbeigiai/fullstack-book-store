import { create } from "zustand";

interface BookQuery {
  categoryId?: number;
  searchText?: string;
}

interface BookQueryStore {
  bookQuery: BookQuery;
  setCategoryId: (categoryId: number) => void;
  setSearchText: (searchText: string) => void;
}

const useBookQueryStore = create<BookQueryStore>((set) => ({
  bookQuery: {},
  setCategoryId: (categoryId) =>
    set((store) => ({ bookQuery: { ...store.bookQuery, categoryId } })),
  setSearchText: (searchText) =>
    set((store) => ({ bookQuery: { ...store.bookQuery, searchText } })),
}));

export default useBookQueryStore;
