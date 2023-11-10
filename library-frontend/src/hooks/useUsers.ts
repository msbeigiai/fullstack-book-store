import { useMutation } from "@tanstack/react-query";
import { User } from "../entities/User";
import { queryClient } from "../main";
import APIClient from "../services/apiClient";

const apiClient = new APIClient<User>("/register");

const useUsers = () =>
  useMutation<User, Error, User>({
    mutationFn: (user: User) => apiClient.registerUser(user),
    onSuccess: (savedUser, newUser) => {
      queryClient.setQueryData<User[]>(["users"], (users) => [
        savedUser,
        ...(users || []),
      ]);
    },
  });

export default useUsers;
