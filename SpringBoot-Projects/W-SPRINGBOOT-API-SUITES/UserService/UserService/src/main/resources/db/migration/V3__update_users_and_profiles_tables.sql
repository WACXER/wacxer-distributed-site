-- Update users table: Add user_type column
ALTER TABLE users
ADD COLUMN IF NOT EXISTS user_type TEXT NOT NULL DEFAULT 'CUSTOMER';

-- Update profiles table: Add unique constraint to user_id
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM pg_constraint
        WHERE conname = 'profiles_user_id_unique'
        AND conrelid = 'profiles'::regclass
    ) THEN
        ALTER TABLE profiles
        ADD CONSTRAINT profiles_user_id_unique UNIQUE (user_id);
    END IF;
END $$;

-- Update profiles table: Set default values for is_premium and is_verified
UPDATE profiles SET is_premium = FALSE WHERE is_premium IS NULL;
UPDATE profiles SET is_verified = FALSE WHERE is_verified IS NULL;

-- Update profiles table: Add NOT NULL constraints to is_premium and is_verified
ALTER TABLE profiles
ALTER COLUMN is_premium SET NOT NULL,
ALTER COLUMN is_verified SET NOT NULL;

-- Update profiles table: Add missing indexes
CREATE INDEX IF NOT EXISTS idx_profiles_user_id ON profiles (user_id);
CREATE INDEX IF NOT EXISTS idx_profiles_is_premium ON profiles (is_premium);
CREATE INDEX IF NOT EXISTS idx_profiles_is_verified ON profiles (is_verified);

-- Update profiles table: Ensure foreign key constraint
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM pg_constraint
        WHERE conname = 'profiles_user_id_fkey'
        AND conrelid = 'profiles'::regclass
    ) THEN
        ALTER TABLE profiles
        ADD CONSTRAINT profiles_user_id_fkey
        FOREIGN KEY (user_id) REFERENCES users(id);
    END IF;
END $$;